import { especialidades } from '@/mocks/especialidad.json';

interface Especialidad {
  nombre: string;
  abreviacion: string;
}

export const Especialidades = () => {
  return (
    <div className=" flex flex-wrap gap-2 justify-center">
      {especialidades.map((especialidad: Especialidad) => (
        <a
          className="text-white bg-mlt-600 hover:bg-mlt-800 hover:scale-105 duration-300 transition-colors focus:outline-none font-semibold rounded-full text-xs text-center py-3  w-32 cursor-pointer"
          key={especialidad.nombre}>
          {especialidad.nombre}
        </a>
      ))}
    </div>
  );
};
