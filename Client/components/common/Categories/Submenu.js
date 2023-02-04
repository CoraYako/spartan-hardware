import styled from 'styled-components'
import { useCycle } from 'framer-motion'
import { MenuButton } from './MenuButton'
import { HiddenMenu } from './HiddenMenu'

export const Submenu = () => {
  const [open, cycleOpen] = useCycle(false, true)
  return (
    <Container>
      <div className="menu" onClick={cycleOpen}>
        <MenuButton isOpen={open} />
        <p>MENU DE CATEGORIAS</p>
      </div>
      <HiddenMenu open={open} action={cycleOpen} />
    </Container>
  )
}

const Container = styled.div`
  background-color: var(--mainBlack);
  color: var(--gray3);
  padding: 1rem 4rem;
  display: flex;
  align-items: center;
  .menu {
    user-select: none;
    display: flex;
    gap: 10px;
    cursor: pointer;

    p {
      font-weight: 700;
    }
  }
`
