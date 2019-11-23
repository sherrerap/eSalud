import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MostrarPersonalMedicoComponent } from './MostrarPersonalMedico.component';

describe('MostrarPersonalMedicoComponent', () => {
  let component: MostrarPersonalMedicoComponent;
  let fixture: ComponentFixture<MostrarPersonalMedicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MostrarPersonalMedicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MostrarPersonalMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
