import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { delay, mergeMap, materialize, dematerialize } from 'rxjs/operators';

// lista de usuarios registrados en almacenamiento local
//let users = JSON.parse(localStorage.getItem('users')) || [];
let users = [{
    dni: "1", nombre: 'Jason', apellido: 'Watmore', password: 'test', rol: 'paciente', localidad: 'cr',
    especialidad: '', medico: '', telefono: '1245', centro: 'm3', email: 'jfa@fg.ces'
}];


@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const { url, method, headers, body } = request;

        // simula mediante un delayed observable una llamada al server api
        return of(null)
            .pipe(mergeMap(handleRoute))
            .pipe(materialize()) // llama a materialize y dematerialize para asegurar el delay incluso si se lanza un error (https://github.com/Reactive-Extensions/RxJS/issues/648)
            .pipe(delay(500))
            .pipe(dematerialize());

        function handleRoute() {
            switch (true) {
                case url.endsWith('/auth/login') && method === 'POST':
                    return authenticate();
                case url.endsWith('/auth/register') && method === 'POST':
                    return register();
                case url.endsWith('/users') && method === 'GET':
                    return getUsers();
                case url.match(/\/users\/\d+$/) && method === 'DELETE':
                    return deleteUser();
                default:
                    return next.handle(request);
            }
        }

        // funciones de enrutado

        function authenticate() {
            const { dni, password } = body;
            const user = users.find(x => x.dni === dni && x.password === password);
            console.log(user)
            if (!user) return error('DNI o contraseña incorrectos');
            return ok({
                dni: user.dni,
                nombre: user.nombre,
                apellido: user.apellido,
                rol: user.rol,
                localidad: user.localidad,
                especialidad: user.especialidad,
                medico: user.medico,
                telefono: user.telefono,
                centro: user.centro,
                email: user.email,
                token: 'fake-jwt-token'
            })
        }

        function register() {
            const user = body

            if (users.find(x => x.dni === user.dni)) {
                return error('El DNI "' + user.dni + '" ya está registrado')
            }

            users.push(user);
            localStorage.setItem('users', JSON.stringify(users));

            return ok();
        }

        function getUsers() {
            if (!isLoggedIn()) return unauthorized();
            return ok(users);
        }

        function deleteUser() {
            if (!isLoggedIn()) return unauthorized();

            users = users.filter(x => x.dni !== (idFromUrl() as unknown as string));
            localStorage.setItem('users', JSON.stringify(users));
            return ok();
        }

        // funciones del helper

        function ok(body?) {
            return of(new HttpResponse({ status: 200, body }))
        }

        function error(message) {
            return throwError({ error: { message } });
        }

        function unauthorized() {
            return throwError({ status: 401, error: { message: 'Unauthorised' } });
        }

        function isLoggedIn() {
            return headers.get('Authorization') === 'Bearer fake-jwt-token';
        }

        function idFromUrl() {
            const urlParts = url.split('/');
            return parseInt(urlParts[urlParts.length - 1]);
        }
    }
}

export const fakeBackendProvider = {
    // se usa un Fake Backend en lugar de un servicio HTTP como prueba
    provide: HTTP_INTERCEPTORS,
    useClass: FakeBackendInterceptor,
    multi: true
};