import { AnimatePresence, motion } from 'framer-motion'
import styled from 'styled-components'

export const Accordion = ({
  i,
  expanded,
  setExpanded,
  disabled,
  children,
  title,
}) => {
  const isOpen = i === expanded

  // By using `AnimatePresence` to mount and unmount the contents, we can animate
  // them in and out while also only rendering the contents of open accordions
  return (
    <>
      <AccordionHeader
        initial={false}
        disabled={!disabled}
        animate={{
          backgroundColor: isOpen ? '#97ea9b' : '#120628',
          color: isOpen ? '#120628' : '#16E000',
        }}
        onClick={() => {
          disabled && setExpanded(isOpen ? false : i)
        }}
      >
        <h2>{title}</h2>
      </AccordionHeader>
      <AnimatePresence initial={false}>
        {isOpen && (
          <motion.section
            key="content"
            initial="collapsed"
            animate="open"
            exit="collapsed"
            variants={{
              open: { opacity: 1, height: 'auto' },
              collapsed: { opacity: 0, height: 0 },
            }}
            transition={{ duration: 0.8, ease: [0.04, 0.62, 0.23, 0.98] }}
          >
            {children}
          </motion.section>
        )}
      </AnimatePresence>
    </>
  )
}

const AccordionHeader = styled(motion.div)`
  width: 100%;
  height: 52px;
  border-radius: 8px;
  display: flex;
  align-items: center;
  padding: 0 16px;
  color: #16e000;
  text-transform: uppercase;
  cursor: ${(props) => (props.disabled ? 'inherit' : 'pointer')};
  opacity: ${(props) => props.disabled && '0.7'};
`
