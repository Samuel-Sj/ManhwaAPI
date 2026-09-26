import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManhwaSearch } from './manhwa-search';

describe('ManhwaSearch', () => {
  let component: ManhwaSearch;
  let fixture: ComponentFixture<ManhwaSearch>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManhwaSearch],
    }).compileComponents();

    fixture = TestBed.createComponent(ManhwaSearch);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
