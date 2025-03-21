import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoundationComponent } from './foundation.component';

describe('FoundationComponent', () => {
  let component: FoundationComponent;
  let fixture: ComponentFixture<FoundationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FoundationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FoundationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
