import Link from 'next/link'
import styled from 'styled-components'
import { motion } from 'framer-motion'

export const Button = ({ text, action, to, secondary, isLoading }) => {
  return (
    <>
      {to ? (
        <Link passHref href={to} secondary={secondary} isLoading={isLoading}>
          {text}
        </Link>
      ) : (
        <Btn
          whileHover={{
            backgroundColor: '#302544',
            transition: { duration: 0.3 },
          }}
          whileTap={{
            backgroundColor: '#ffffff00',
            color: '#120628',
            outline: '1px solid #120628',
            transition: { duration: 0.2 },
          }}
          onClick={action}
          secondary={secondary}
          isLoading={isLoading}
        >
          {text}
        </Btn>
      )}
    </>
  )
}

const Btn = styled(motion.button)`
  border: none;
  min-width: 9rem;
  cursor: pointer;
  font-family: 'Prompt';
  font-style: normal;
  font-weight: 500;
  font-size: 13px;
  line-height: 16px;
  text-align: center;
  letter-spacing: 0.02em;
  color: #fff;
  padding: 0.8rem 1.6rem;
  background-color: var(--secondaryViolet1);
  border-radius: 3px;
`
