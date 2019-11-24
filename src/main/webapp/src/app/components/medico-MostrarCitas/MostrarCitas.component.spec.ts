import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MostrarCitasComponent } from './MostrarCitas.component';

describe('MostarMedicoComponent', () => {
  let component: MostrarCitasComponent;
  let fixture: ComponentFixture<MostrarCitasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MostrarCitasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MostrarCitasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
