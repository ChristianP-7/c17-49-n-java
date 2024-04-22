import dynamic from 'next/dynamic';

const VideoLlamadaComp = dynamic(
  () => {
    return import('@/app/ui/VideoLlamada');
  },
  { ssr: false }
);
export default function misConsultas() {
  return <VideoLlamadaComp />;
}
