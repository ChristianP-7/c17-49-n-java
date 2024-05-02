import { create } from 'zustand';


interface State {
    name: string;
    isLoggedIn: boolean;
    isFinishCall: boolean;
    isInProgressCall: boolean;
    cambiarLogin: () => void;
    finCall: () => void;
    inProgressCall: () => void;
}

export const useUserStore = create<State>((set) => ({
    name: 'userStore',
    isLoggedIn: false,
    isFinishCall: false,
    isInProgressCall: false,
    cambiarLogin: () => set((state) => ({ isLoggedIn: !state.isLoggedIn })),
    finCall: () => set((state) => ({ isFinishCall: !state.isFinishCall })),
    inProgressCall: () => set((state) => ({ isInProgressCall: !state.isInProgressCall })),
}));




