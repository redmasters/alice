import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RotaCustomComponent } from './rota-custom.component';

describe('RotaCustomComponent', () => {
  let component: RotaCustomComponent;
  let fixture: ComponentFixture<RotaCustomComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RotaCustomComponent]
    });
    fixture = TestBed.createComponent(RotaCustomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
