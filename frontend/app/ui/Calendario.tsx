'use client';

import { useState } from 'react';

interface Props {}

export const Calendario: React.FC<Props> = () => {
  const [fecha, setFecha] = useState<Date>(new Date());
  const [diaSeleccionado, setDiaSeleccinado] = useState<number>(new Date().getDate());

  const cambiarMes = (incrementar: number) => {
    console.log('cambiando mes');
    setFecha((prevFecha) => {
      const nuevaFecha = new Date(prevFecha);
      nuevaFecha.setMonth(nuevaFecha.getMonth() + incrementar);
      return nuevaFecha;
    });
  };

  const primerDiaDelMes = new Date(fecha.getFullYear(), fecha.getMonth(), 1).getDay();
  const diasEnMes: number = new Date(fecha.getFullYear(), fecha.getMonth() + 1, 0).getDate();
  const seleccionarDia = (dia: number): void => {
    setDiaSeleccinado(dia);
  };

  return (
    <div className="flex items-center justify-center from-red-100 via-red-300 to-red-500 h-58">
      <div className="md:w-[550px] md:h-[230px] p-4 max-w-[389px] md:max-w-full overflow-hidden rounded-2xl shadow-2xl flex flex-col bg-white">
        <div className="flex justify-between pb-4">
          <div
            className="cursor-pointer -rotate-90 flex items-center"
            onClick={() => cambiarMes(-1)}>
            <svg
              width="12"
              height="10"
              viewBox="0 0 12 7"
              fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="M11.001 6L6.00098 1L1.00098 6"
                stroke="black"
                strokeOpacity="0.4"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
              />
            </svg>
          </div>
          <span className="uppercase text-sm font-semibold text-gray-600">
            {fecha.toLocaleString('default', { month: 'long' })} - {fecha.getFullYear()}
          </span>
          <div className="cursor-pointer rotate-90" onClick={() => cambiarMes(1)}>
            <svg
              width="12"
              height="10"
              viewBox="0 0 12 7"
              fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="M11.001 6L6.00098 1L1.00098 6"
                stroke="black"
                strokeOpacity="0.4"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
              />
            </svg>
          </div>
        </div>

        {/* Días de la semana */}
        <div className="flex justify-between font-medium uppercase text-xs pt-4 pb-2 border-t">
          {['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'].map((diaSemana) => (
            <h2
              key={diaSemana}
              className="px-3 border rounded-xl w-14 h-5 flex items-center justify-center border-mlt-600 text-white bg-mlt-600 shadow-md">
              {diaSemana}
            </h2>
          ))}
        </div>

        {/* Días del mes */}

        {[...Array(Math.ceil((diasEnMes + primerDiaDelMes) / 7))].map((_, semanaIndex) => (
          <div
            key={semanaIndex}
            className="flex justify-between font-medium text-xs pb-2 select-none">
            {[...Array(7)].map((_, diaIndex) => {
              const dia = semanaIndex * 7 + diaIndex - primerDiaDelMes + 1;
              const isSelected = dia === diaSeleccionado;
              const esDomingo = diaIndex === 0;
              const esDiaDelMes = dia > 0 && dia <= diasEnMes;
              const estiloDia = `px-1 w-14 flex justify-center items-center border rounded-xl hover:border-mlt-600 cursor-pointer ${
                isSelected ? 'text-white bg-mlt-600 rounded-2xl shadow-md' : ''
              } ${
                !esDiaDelMes || esDomingo
                  ? 'opacity-50 cursor-not-allowed border-none select-none'
                  : ''
              }`;

              return (
                <span
                  key={diaIndex}
                  className={estiloDia}
                  onClick={() => (esDiaDelMes && !esDomingo ? seleccionarDia(dia) : null)}>
                  {esDiaDelMes ? dia : ''}
                </span>
              );
            })}
          </div>
        ))}
      </div>
    </div>
  );
};
