import OutstandingIcon from '@/public/icons/Outstanding'
import PromotionIcon from '@/public/icons/Promotion'
import ShippingIcon from '@/public/icons/Shipping'
import styled from 'styled-components'

export const Label = ({ typeLabel, msg = '' }) => {
  return (
    <Lbl typeLabel={typeLabel}>
      {typeLabel === 'promotion' && (
        <>
          <p>Promoción</p>
          <PromotionIcon />
        </>
      )}
      {typeLabel === 'outstanding' && (
        <>
          <p>Destacado</p>
          <OutstandingIcon />
        </>
      )}
      {typeLabel === 'shipping' && (
        <>
          <p>{msg}</p>
          <ShippingIcon />
        </>
      )}
    </Lbl>
  )
}

const Lbl = styled.label`
  position: absolute;
  top: 1rem;
  left: 1rem;
  background-color: ${(props) =>
    props?.typeLabel !== 'promotion'
      ? 'var(--tertiaryNavy1)'
      : 'var(--primaryGreen1)'};
  width: auto;
  height: 3.2rem;
  border-radius: 0.6rem;
  padding: 1rem 0.7rem 1rem 0.7rem;
  display: flex;
  gap: 0.5rem;
  p {
    font-family: 'Raleway';
    font-style: normal;
    font-weight: 600;
    font-size: 14px;
    line-height: 16px;
    display: flex;
    align-items: center;
    color: #120628;
  }
`
