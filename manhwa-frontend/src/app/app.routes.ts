import { Routes } from '@angular/router';
import { ManhwaSearch } from './component/manhwa-search/manhwa-search';
import { ManhwaForm } from './component/manhwa-save/manhwa-save';
import { ManhwaResult } from './component/manhwa-result/manhwa-result';
import { Login } from './component/login/login';

export const routes: Routes = [
    { path: '', redirectTo: '/auth/login', pathMatch: 'full' },
    { path: 'auth/login', component: Login },
    { path: 'novo', component: ManhwaForm },
    { path: 'buscar', component: ManhwaSearch },
    { path: 'resultados', component: ManhwaResult }
];
