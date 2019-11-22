import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MostrarEspecialidadesComponent } from "./MostrarEspecialidades.component";

describe('MostarEspecialidadesComponent', () => {
  let component: MostrarEspecialidadesComponent;
  let fixture: ComponentFixture<MostrarEspecialidadesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MostrarEspecialidadesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MostrarEspecialidadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
