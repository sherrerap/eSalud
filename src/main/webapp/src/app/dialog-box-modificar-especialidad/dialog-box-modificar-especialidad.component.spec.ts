import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogBoxModificarEspecialidadComponent } from './dialog-box-modificar-especialidad.component';

describe('DialogBoxModificarEspecialidadComponent', () => {
  let component: DialogBoxModificarEspecialidadComponent;
  let fixture: ComponentFixture<DialogBoxModificarEspecialidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogBoxModificarEspecialidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogBoxModificarEspecialidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
