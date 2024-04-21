import { Profile } from '@/app/ui/Profile';

export default function Perfil() {
  return (
    <>
      <div className="items-center justify-center md:mx-auto mt-10 md:mt-0 space-y-10 md:w-full max-w-[440px] md:max-w-[1200px] md:mr-6 md:space-y-6 px-2 mb-4 md:mb-0 select-none">
        <section className="bg-white rounded-xl p-4">
          <Profile />
        </section>
      </div>
    </>
  );
}
