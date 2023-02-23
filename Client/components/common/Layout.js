import { AnimatePresence } from 'framer-motion'
import styled from 'styled-components'
import { Navbar } from './Navbar'
import { Footer } from './Footer'
import Modal from './Modal'
import { GlobalContext } from '@/context/GlobalContext'
import { useContext } from 'react'
import { LoginModal } from '../public/LoginModal'

const Layout = ({ children }) => {
  const { contextDataGlobal, setContextDataGlobal } = useContext(GlobalContext)

  const setShowModal = (showModal) => {
    setContextDataGlobal({ ...contextDataGlobal, showModal })
  }
  return (
    <PageContainer>
      <Modal
        setShowModal={setShowModal}
        showModal={contextDataGlobal.showModal}
        padding="0"
      >
        <LoginModal />
      </Modal>
      <Navbar />
      <AnimatePresence mode="wait">{children}</AnimatePresence>
      <Footer />
    </PageContainer>
  )
}

export default Layout

const PageContainer = styled.div`
  background-color: var(--mainBg);
  height: 100%;
  width: 100%;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
`
