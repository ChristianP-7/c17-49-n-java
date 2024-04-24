import dynamic from 'next/dynamic';

const VideoLlamadaComp = dynamic(
  () => {
    return import('@/app/ui/atencion virtual/VideoLlamada');
  },
  { ssr: false }
);
export default function misConsultas() {
  return <VideoLlamadaComp />;
}
