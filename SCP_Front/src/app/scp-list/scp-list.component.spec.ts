import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScpListComponent } from './scp-list.component';

describe('ScpListComponent', () => {
  let component: ScpListComponent;
  let fixture: ComponentFixture<ScpListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScpListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScpListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
