import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidenavMedicoComponent } from './sidenavMedico.component';

describe('SidenavMedicoComponent', () => {
  let component: SidenavMedicoComponent;
  let fixture: ComponentFixture<SidenavMedicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidenavMedicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidenavMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
