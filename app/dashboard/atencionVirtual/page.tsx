import dynamic from 'next/dynamic';
import { Suspense } from 'react';

const VideoLlamadaComp = dynamic(
  () => {
    return import('@/app/ui/atencion virtual/VideoLlamada');
  },
  { ssr: false }
);
export default async function misConsultas() {
  return <VideoLlamadaComp />;
}
