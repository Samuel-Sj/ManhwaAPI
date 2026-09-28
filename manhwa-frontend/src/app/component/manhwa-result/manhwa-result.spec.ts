import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManhwaResult } from './manhwa-result';

describe('ManhwaResult', () => {
  let component: ManhwaResult;
  let fixture: ComponentFixture<ManhwaResult>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManhwaResult],
    }).compileComponents();

    fixture = TestBed.createComponent(ManhwaResult);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
