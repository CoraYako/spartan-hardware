import CheckboxSpring from '@/components/common/Checkbox'
import styled from 'styled-components'

export const CardShipping = ({ price, info, titleName }) => {
  return (
    <Container>
      <div className="nav">
        <h4>{titleName}</h4>
      </div>
      <div className="content">
        <CheckboxSpring text="Retiro en Deposito Floresta (CABA)" />
        <p className="price">{price}</p>
        <p className="info">{info}</p>
      </div>
    </Container>
  )
}

const Container = styled.div`
  border-radius: 8px;
  display: flex;
  flex-direction: column;
  max-width: 300px;
  .nav {
    border-radius: 8px 8px 0px 0px;
    padding: 4px 12px;
    background: #120628;
    h4 {
      font-style: normal;
      font-weight: 700;
      font-size: 14px;
      line-height: 26px;
      text-transform: uppercase;
      color: #16e000;
    }
  }
  .content {
    border-radius: 0px 0px 8px 8px;
    background-color: #fff;
    display: flex;
    flex-direction: column;
    gap: 10px;
    padding: 20px;
    .price {
      font-weight: 600;
      font-size: 14px;
      line-height: 26px;
    }
    .info {
      font-weight: 400;
      font-size: 14px;
      line-height: 26px;
    }
  }
`
