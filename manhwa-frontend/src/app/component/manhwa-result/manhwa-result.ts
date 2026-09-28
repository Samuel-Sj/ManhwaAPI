import { Component, signal, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import Manhwa from '../../../models/manhwa';
import { ManhwaService } from '../../../services/manhwa.service';

@Component({
  selector: 'app-manhwa-result',
  imports: [],
  templateUrl: './manhwa-result.html',
  styleUrl: './manhwa-result.css',
})
export class ManhwaResult implements OnInit {
  manhwa_result = signal<Manhwa | null>(null);
  search_manhwa = '';
  loading = signal(false);
  error = signal<string | null>(null);

  constructor(
    private manhwaService: ManhwaService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.search_manhwa = params['q'] ?? '';
      if (this.search_manhwa) {
        this.result();
      }
    });
  }

  result() {
    this.loading.set(true);
    this.manhwa_result.set(null);
    this.error.set(null);

    this.manhwaService
      .getByName(this.search_manhwa.toLowerCase().trim())
      .subscribe({
        next: (response) => {
          this.manhwa_result.set(response);
          this.loading.set(false);
        },
        error: (err) => {
          this.error.set(
            err.status === 404
              ? 'Nenhum manhwa encontrado'
              : 'Erro ao buscar manhwa'
          );
          this.loading.set(false);
        },
      });
  }
}
