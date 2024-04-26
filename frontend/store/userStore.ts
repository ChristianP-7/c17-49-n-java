import { create } from 'zustand';

export const useUserStore = create<State>((set) => ({
    name: 'userStore',
    isLoggedIn: false,
    cambiarLogin: (isLoggedIn: boolean) => set({ isLoggedIn }),
}));

interface State {
    name: string;
    isLoggedIn: boolean;
    /* canbiarLogin = (isLoggedIn: boolean) => void */
}


