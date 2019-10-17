import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MostrarMedicoComponent } from './MostrarMedico.component';

describe('MostarMedicoComponent', () => {
  let component: MostrarMedicoComponent;
  let fixture: ComponentFixture<MostrarMedicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MostrarMedicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MostrarMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
