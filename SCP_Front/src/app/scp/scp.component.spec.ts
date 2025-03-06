import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScpComponent } from './scp.component';

describe('ScpComponent', () => {
  let component: ScpComponent;
  let fixture: ComponentFixture<ScpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScpComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
