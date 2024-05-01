import { create } from 'zustand';


interface State {
    name: string;
    isLoggedIn: boolean;
    cambiarLogin: () => void
}

export const useUserStore = create<State>((set) => ({
    name: 'userStore',
    isLoggedIn: false,
    cambiarLogin: () => set((state) => ({ isLoggedIn: true })),
}));




