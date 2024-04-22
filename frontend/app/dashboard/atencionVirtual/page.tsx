
'use client'

import * as React from 'react';
import { useEffect, useRef } from 'react';

import { ZegoUIKitPrebuilt } from '@zegocloud/zego-uikit-prebuilt';

const userId_1 = 'Usuario';
const userId_2 = 'Usuario';

export function getUrlParams(url = window.location.href) {
  
  let urlStr = url.split('?')[1];
  return new URLSearchParams(urlStr);
}

export default function AtencionVirtual() {
  
  const FIXED_ROOM_ID = 'your-fixed-room-id';
  const roomID = getUrlParams().get('roomID') || FIXED_ROOM_ID;
  const containerRef = useRef(null);

  const startMeeting = async () => {
    const appID = 1166952768;
    const serverSecret = "37718261e157b7e1a6bca9b82957e731";
    const userId = Math.random() > 0.5 ? userId_1 : userId_2;
    const kitToken = ZegoUIKitPrebuilt.generateKitTokenForTest(appID, serverSecret, roomID, userId, userId);

    const zp = ZegoUIKitPrebuilt.create(kitToken);
    zp.joinRoom({
      container: containerRef.current,
      sharedLinks: [
        {
          name: 'Personal link',
          url: window.location.protocol + '//' + window.location.host + window.location.pathname + '?roomID=' + roomID,
        },
      ],
      scenario: {
        mode: ZegoUIKitPrebuilt.GroupCall,
      },
    });

  };

  useEffect(() => {
    startMeeting();
  

    // Agrega el listener para detectar cambios en la visibilidad
    const handleVisibilityChange = () => {
      if (!document.hidden) {
      }
    };

    document.addEventListener('visibilitychange', handleVisibilityChange);

    return () => {
      document.removeEventListener('visibilitychange', handleVisibilityChange);
    };
  }, []); // Sin dependencias para que useEffect se ejecute solo una vez al montar el componente

  return (
    <div
      className="myCallContainer"
      ref={containerRef} // Asigna la referencia al contenedor
      style={{ width: '100vw', height: '100vh' }}
    >
      {/* Contenedor de la llamada */}
    </div>
   
  );
 
}




// 'use client'

// import * as React from 'react';
// import { useEffect, useRef } from 'react'; // Importa useEffect y useRef
// import { ZegoUIKitPrebuilt } from '@zegocloud/zego-uikit-prebuilt';
// import { useRouter } from 'next/navigation';

// const userId_1 = 'Usuario';
// const userId_2 = 'Usuario';

// export function getUrlParams(
//   url = window.location.href
// ) {
//   let urlStr = url.split('?')[1];
//   return new URLSearchParams(urlStr);
// }

// export default function AtencionVirtual() {
//   const router = useRouter()
//   const FIXED_ROOM_ID = 'your-fixed-room-id'
//   const roomID = getUrlParams().get('roomID') || FIXED_ROOM_ID;
//   const containerRef = useRef(null); // Usa useRef para crear una referencia
  
//   useEffect(() => {
//     // Dentro del useEffect, llama a la función myMeeting
//     const myMeeting = async () => {
//       // Genera el Kit Token
//       const appID = 1166952768;
//       const serverSecret = "37718261e157b7e1a6bca9b82957e731";
//       const userId = Math.random()>0.5 ? userId_1 : userId_2
//       const kitToken = ZegoUIKitPrebuilt.generateKitTokenForTest(appID, serverSecret, roomID, userId, userId);

//       // Crea el objeto de instancia a partir del Kit Token
//       const zp = ZegoUIKitPrebuilt.create(kitToken);
//       // Inicia la llamada
//       zp.joinRoom({
//         container: containerRef.current, // Usa la referencia del contenedor
//         sharedLinks: [
//           {
//             name: 'Personal link',
//             url: window.location.protocol + '//' + window.location.host + window.location.pathname + '?roomID=' + roomID,
//           },
//         ],
//         scenario: {
//           mode: ZegoUIKitPrebuilt.GroupCall, // Para implementar llamadas uno a uno, modifica el parámetro aquí a [ZegoUIKitPrebuilt.OneONoneCall].
//         },
//       });
//     };

//     myMeeting();
//     // Manejar el evento visibilitychange para reanudar la llamada cuando la pestaña se vuelve a mostrar
//     const handleVisibilityChange = () => {
//       if (!document.hidden) {
//         myMeeting();
//         router.refresh();
//       }
//     };

//     document.addEventListener('visibilitychange', handleVisibilityChange);

//     // Limpiar el evento al desmontar el componente
//     return () => {
//       document.removeEventListener('visibilitychange', handleVisibilityChange);
//     };
    
    
    
    
//     // Llama a la función myMeeting al montar el componente
//   }, []); // Usa un array vacío como dependencia para que useEffect se ejecute solo una vez al montar el componente

//   return (
//     <div
//       className="myCallContainer"
//       ref={containerRef} // Asigna la referencia al contenedor
//       style={{ width: '100vw', height: '100vh' }}
//     ></div>
//   );
// }

// function random(arg0: number) {
//   throw new Error('Function not implemented.');
// }
