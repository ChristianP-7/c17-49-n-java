'use client';

import { useEffect, useRef } from 'react'; // Importa useEffect y useRef
import { ZegoUIKitPrebuilt } from '@zegocloud/zego-uikit-prebuilt';
import { Calificacion } from '../modals/Calificacion';
import { useUserStore } from '@/store/userStore';

function randomID(len: any) {
  let result = '';
  var chars = '12345qwertyuiopasdfgh67890jklmnbvcxzMNBVCZXASDQWERTYHGFUIOLKJP',
    maxPos = chars.length,
    i;
  len = len || 5;
  for (i = 0; i < len; i++) {
    result += chars.charAt(Math.floor(Math.random() * maxPos));
  }
  return result;
}

export function getUrlParams(url = window.location.href) {
  let urlStr = url.split('?')[1];
  return new URLSearchParams(urlStr);
}

const VideoLlamadaComp = () => {
  const finCall = useUserStore((state) => state.finCall);
  const callFined = useUserStore((state) => state.isFinishCall);
  const initCall = useUserStore((state) => state.inProgressCall);
  const endCall = useUserStore((state) => state.inProgressCall);
  const roomID = getUrlParams().get('roomID') || 'videollamadaid';
  const containerRef = useRef(null); // Usa useRef para crear una referencia
  useEffect(() => {
    // Dentro del useEffect, llama a la función myMeeting
    const myMeeting = async () => {
      // Genera el Kit Token
      const appID = 1166952768;
      const serverSecret = '37718261e157b7e1a6bca9b82957e731';
      const kitToken = ZegoUIKitPrebuilt.generateKitTokenForTest(
        appID,
        serverSecret,
        roomID,
        randomID(5),
        randomID(5)
      );

      // Crea el objeto de instancia a partir del Kit Token
      const zp = ZegoUIKitPrebuilt.create(kitToken);
      // Inicia la llamada
      zp.joinRoom({
        container: containerRef.current, // Usa la referencia del contenedor
        turnOnMicrophoneWhenJoining: true,
        turnOnCameraWhenJoining: true,
        showMyCameraToggleButton: true,
        showMyMicrophoneToggleButton: true,
        showAudioVideoSettingsButton: true,
        showScreenSharingButton: false,
        showTextChat: true,
        showUserList: true,
        showLayoutButton: true,
        showLeaveRoomConfirmDialog: false,
        maxUsers: 2,
        layout: 'Auto',
        showLeavingView: false,
        showPreJoinView: false,
        whiteboardConfig: {
          showAddImageButton: true,
        },
        scenario: {
          mode: ZegoUIKitPrebuilt.OneONoneCall,
        },
        branding: {
          logoURL: '/Medilatam.svg',
        },
        onUserAvatarSetter: (userList) => {
          userList.forEach((user: any) => {
            user.setUserAvatar('/imageProfile/imagen.jpg');
          });
        },
        onJoinRoom: () => {
          initCall();
        },
        onLeaveRoom: () => {
          finCall();
          endCall();
        },
      });
    };

    myMeeting();
    // Manejar el evento visibilitychange para reanudar la llamada cuando la pestaña se vuelve a mostrar
    const handleVisibilityChange = () => {
      if (!document.hidden) {
        myMeeting();
      }
    };

    document.addEventListener('visibilitychange', handleVisibilityChange);

    // Limpiar el evento al desmontar el componente
    return () => {
      document.removeEventListener('visibilitychange', handleVisibilityChange);
    };

    // Llama a la función myMeeting al montar el componente
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []); // Usa un array vacío como dependencia para que useEffect se ejecute solo una vez al montar el componente
  const containerStyles = {
    borderRadius: '20px',
    padding: '10px',
    width: '1200px',
    height: '560px',
    backgroundColor: '#fff',
  };
  const mobileStyles = `
    @media (max-width: 768px) {
      width: 90%;
      height: auto;
      padding: 5px;
      borderRadius: 10px;
    }
  `;
  const combinedStyles = { ...containerStyles, style: mobileStyles };
  return (
    <>
      <div
        className={`${
          callFined ? 'hidden' : 'flex'
        }  md:max-w-[1200px] md:mt-4 md:mr-6 -mt-52 md:mx-auto mx-2`}
        ref={containerRef}
        style={combinedStyles}></div>
      <Calificacion />
    </>
  );
};
export default VideoLlamadaComp;
