import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SsKancComponent } from './ss-kanc.component';

describe('SsKancComponent', () => {
  let component: SsKancComponent;
  let fixture: ComponentFixture<SsKancComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SsKancComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SsKancComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
