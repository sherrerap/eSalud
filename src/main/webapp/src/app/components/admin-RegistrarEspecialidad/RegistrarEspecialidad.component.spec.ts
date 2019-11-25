import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarEspecialidadComponent } from './RegistrarEspecialidad.component';

describe('RegistrarEspecialidadComponent', () => {
  let component: RegistrarEspecialidadComponent;
  let fixture: ComponentFixture<RegistrarEspecialidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrarEspecialidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrarEspecialidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
