import { Routes } from '@angular/router';

import { Login } from './component/login/login';
import { Layout } from './component/layout/layout';
import { ManhwaSearch } from './component/manhwa-search/manhwa-search';
import { ManhwaForm } from './component/manhwa-save/manhwa-save';
import { ManhwaResult } from './component/manhwa-result/manhwa-result';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/auth/login',
        pathMatch: 'full'
    },

    // Login não possui Layout
    {
        path: 'auth/login',
        component: Login
    },

    // Tudo aqui terá o Layout
    {
        path: '',
        component: Layout,
        children: [
            {
                path: 'buscar',
                component: ManhwaSearch
            },
            {
                path: 'novo',
                component: ManhwaForm
            },
            {
                path: 'resultados',
                component: ManhwaResult
            }
        ]
    }
];