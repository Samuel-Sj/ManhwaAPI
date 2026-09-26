import { Routes } from '@angular/router';
import { ManhwaSearch } from './component/manhwa-search/manhwa-search';
import { ManhwaForm } from './component/manhwa-save/manhwa-save';

export const routes: Routes = [
    { path: '', redirectTo: 'buscar', pathMatch: 'full' },
    {path: 'novo', component: ManhwaForm},
    {path: 'buscar', component: ManhwaSearch}
];
