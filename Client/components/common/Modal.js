import { motion, AnimatePresence } from 'framer-motion'
import { useRef } from 'react'
import styled from 'styled-components'

const backdrop = {
  visible: { opacity: 1 },
  hidden: { opacity: 0 },
}

const modal = {
  hidden: { opacity: 0, y: '-100vh' },
  visible: {
    opacity: 1,
    y: '15vh',
    transition: {
      delay: 0.5,
      type: 'spring',
      stiffness: 50,
      damping: 15,
    },
  },
}

const Modal = ({
  showModal,
  setShowModal,
  children,
  cypress = 'modal',
  hideCross = false,
  padding,
}) => {
  const containerRef = useRef()

  return (
    <AnimatePresence mode="wait">
      {showModal && (
        <Backdrop
          variants={backdrop}
          onClick={(e) => {
            if (!containerRef.current.contains(e.target)) {
              setShowModal(false)
            }
          }}
          initial="hidden"
          animate="visible"
          exit="hidden"
          key="backdrop"
        >
          <ModalContainer
            padding={padding}
            data-cy={cypress}
            ref={containerRef}
            variants={modal}
            initial="hidden"
            animate="visible"
            exit="hidden"
            key="modalContainer"
          >
            {!hideCross && <div onClick={() => setShowModal(false)} />}
            {children}
          </ModalContainer>
        </Backdrop>
      )}
    </AnimatePresence>
  )
}

const Backdrop = styled(motion.div)`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: #1e1e1ee8;
  z-index: 90;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  overflow-y: scroll;
  ::-webkit-scrollbar {
    display: none;
    -ms-overflow-style: none;
    scrollbar-width: none;
  }
`

const ModalContainer = styled(motion.div)`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: ${(props) => (props?.padding ? props?.padding : '1.4rem 3rem 4rem')};
  background: #ffffff;
  border-radius: 16px;
  margin: 0 auto;
  position: relative;
  max-width: 92%;
  z-index: 100;
`

export default Modal
