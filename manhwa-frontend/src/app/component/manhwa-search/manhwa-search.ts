import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

import Manhwa from '../../../models/manhwa';
import { ManhwaService } from '../../../services/manhwa.service';

@Component({
  selector: 'app-manhwa-search',
  imports: [FormsModule],
  templateUrl: './manhwa-search.html',
  styleUrl: './manhwa-search.css',
})
export class ManhwaSearch {
  searchTerm = '';

  result = signal<Manhwa | null>(null);
  error = signal<string | null>(null);

  constructor(private manhwaService: ManhwaService) {}

  search() {
    const request = this.manhwaService.getByName(
      this.searchTerm.toLowerCase().trim()
    );

    request.subscribe({
      next: (manhwa) => {
        this.result.set(manhwa);
        this.error.set(null);
      },

      error: (err) => {
        this.result.set(null);

        this.error.set(
          err.status === 404
            ? 'Nenhum Manhwa encontrado'
            : 'Erro ao buscar Manhwa'
        );
      },
    });
  }
}
