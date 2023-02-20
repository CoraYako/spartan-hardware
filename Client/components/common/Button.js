import Link from 'next/link'
import styled from 'styled-components'
import { motion } from 'framer-motion'

export const Button = ({
  text = '',
  action,
  to = '',
  secondary,
  isLoading = false,
  type = '',
  width,
  colorFocus,
  margin,
}) => {
  return (
    <>
      {to ? (
        <CustomLink
          passHref
          href={to}
          secondary={secondary}
          $isLoading={isLoading}
        >
          {text}
        </CustomLink>
      ) : (
        <Btn
          whileHover={{
            backgroundColor: '#302544',
            transition: { duration: 0.3 },
          }}
          whileTap={{
            backgroundColor: `${colorFocus || '#ffffff00'}`,
            color: `${secondary ? '#fff' : '#120628'}`,
            outline: '1px solid #120628',
            transition: { duration: 0.2 },
          }}
          onClick={action}
          secondary={secondary}
          $isLoading={isLoading}
          type={type}
          width={width}
          margin={margin}
        >
          {text}
        </Btn>
      )}
    </>
  )
}

const Btn = styled(motion.button)`
  border: none;
  width: ${(props) => props.width};
  min-width: 9rem;
  margin: ${(props) => props.margin};
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
  background-color: ${(props) =>
    props.secondary === 'green'
      ? 'var(--primaryGreen1)'
      : (props.secondary === 'violet' && 'var(--tertiaryNavy1)') ||
        'var(--secondaryViolet1)'};
  border-radius: 3px;
`
const CustomLink = styled(Link)``
