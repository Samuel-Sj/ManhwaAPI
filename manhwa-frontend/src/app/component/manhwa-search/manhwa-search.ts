import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-manhwa-search',
  imports: [FormsModule],
  templateUrl: './manhwa-search.html',
  styleUrl: './manhwa-search.css',
})
export class ManhwaSearch {
  searchTerm = '';

  constructor(private router: Router) {}

  search() {
    const term = this.searchTerm.trim();
    if (!term) return;

    this.router.navigate(['/resultados'], { queryParams: { q: term } });
  }
}
