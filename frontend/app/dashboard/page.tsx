import { Calendario } from '@/app/ui/Calendario';
import { Especialidades } from '../ui/Especialidades';
import { Profesionales } from '../ui/Profesionales';
import { SioNo } from '../ui/modals/SioNo';

export default async function Dashboard() {
  return (
    <>
      <div className="items-center justify-center md:mx-auto mt-10 md:mt-0 space-y-10 md:w-full max-w-[340px] md:max-w-[800px] lg:[1000] xl:max-w-[1250px] 2xl:max-w-[1850px] md:mr-6 md:space-y-6 mb-4 md:mb-0 select-none">
        <section className="bg-white rounded-xl shadow-2xl py-2 mx-auto md:w-full">
          <h1 className="font-bold text-lg text-center border-b-2 mb-1">Especialidades</h1>
          <Especialidades />
        </section>

        <section className="flex flex-col justify-center items-center rounded-xl">
          <Calendario />
        </section>
        <section className="bg-white shadow-2xl m-0 rounded-2xl flex flex-col justify-start gap-1 h-[210px] md:px-2 overflow-y-scroll scroll-container">
          <div className="rounded-xl bg-white py-2 sticky top-0">
            <h1 className="font-bold text-lg text-center border-b-2 mb-1">
              Profesionales Disponibles
            </h1>
          </div>
          <Profesionales />
        </section>
      </div>
    </>
  );
}
