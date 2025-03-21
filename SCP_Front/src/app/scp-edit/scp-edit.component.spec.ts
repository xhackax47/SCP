import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScpEditComponent } from './scp-edit.component';

describe('ScpEditComponent', () => {
  let component: ScpEditComponent;
  let fixture: ComponentFixture<ScpEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScpEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScpEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
