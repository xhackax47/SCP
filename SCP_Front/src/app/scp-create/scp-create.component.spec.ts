import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScpCreateComponent } from './scp-create.component';

describe('ScpCreateComponent', () => {
  let component: ScpCreateComponent;
  let fixture: ComponentFixture<ScpCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScpCreateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScpCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
