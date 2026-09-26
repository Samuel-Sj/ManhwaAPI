import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManhwaSave } from './manhwa-save';

describe('ManhwaSave', () => {
  let component: ManhwaSave;
  let fixture: ComponentFixture<ManhwaSave>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManhwaSave],
    }).compileComponents();

    fixture = TestBed.createComponent(ManhwaSave);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
