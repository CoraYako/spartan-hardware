import styled from 'styled-components'
import { useCycle } from 'framer-motion'
import { MenuButton } from './MenuButton'
import { HiddenMenu } from './HiddenMenu'
import { ButtonViolet } from './ButtonViolet'
import { Switch } from './Switch'

export const Submenu = () => {
  const [open, cycleOpen] = useCycle(false, true)
  return (
    <Container>
      <div className="categories" onClick={cycleOpen}>
        <MenuButton isOpen={open} />
        <p>MENU DE CATEGORÍAS</p>
      </div>
      <ButtonViolet />
      <Switch />
      <HiddenMenu open={open} action={cycleOpen} />
    </Container>
  )
}

const Container = styled.div`
  background-color: var(--secondaryViolet1);
  color: var(--gray3);
  padding: 1rem 4rem;
  display: flex;
  align-items: center;
  position: relative;
  .categories {
    user-select: none;
    display: flex;
    gap: 10px;
    cursor: pointer;
    align-items: flex-end;

    p {
      font-weight: 700;
      font-size: 16px;
    }
  }
`
