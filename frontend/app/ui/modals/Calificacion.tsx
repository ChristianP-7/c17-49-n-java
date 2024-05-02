'use client';
import { useUserStore } from '@/store/userStore';
import Link from 'next/link';

export const Calificacion = () => {
  const finCall = useUserStore((state) => state.finCall);
  const endCall = useUserStore((state) => state.isFinishCall);
  const onFinCall = () => {
    finCall();
  };
  return (
    <dialog
      id="popup-modal"
      className={` ${
        endCall ? 'flex' : 'hidden'
      } fixed top-0 left-0 w-full h-full justify-center items-center bg-black bg-opacity-50 z-50  md:inset-0 max-h-full`}>
      <div className="relative w-full max-w-md max-h-full">
        <div className="flex flex-col px-4 items-center justify-center relative bg-white rounded-lg shadow-xl">
          <h2 className="font-bold text-3xl border-b-2 text-center pt-2">Muchas Gracias!!</h2>
          <h3 className="font-semibold text-1xl text-center">
            Le agradeceríamos que tomara un momento para calificar su experiencia.
          </h3>
          <div className="rating my-2">
            <input value="5" name="rating" id="star5" type="radio" />
            <label htmlFor="star5"></label>
            <input value="4" name="rating" id="star4" type="radio" />
            <label htmlFor="star4"></label>
            <input value="3" name="rating" id="star3" type="radio" />
            <label htmlFor="star3"></label>
            <input value="2" name="rating" id="star2" type="radio" />
            <label htmlFor="star2"></label>
            <input value="1" name="rating" id="star1" type="radio" />
            <label htmlFor="star1"></label>
          </div>
          <Link
            href="/dashboard"
            onClick={onFinCall}
            className="text-white bg-mlt-700 hover:bg-mlt-800 hover:scale-105 duration-300   transition-colors focus:outline-none font-medium rounded-full text-sm text-center p-2 w-24 mb-4">
            Confirmar
          </Link>
        </div>
      </div>
    </dialog>
  );
};
