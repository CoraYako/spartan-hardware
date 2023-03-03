import Image from 'next/image'
import Link from 'next/link'
import styled from 'styled-components'

export const CardCategory = ({
  selected,
  disabled = false,
  nameProduct,
  category,
  icon,
  isColumn = false,
  action,
  step,
  setcategory,
  slug,
}) => {
  selected && setcategory(slug)
  return (
    <CardContainer
      disabled={disabled}
      selected={selected}
      isColumn={isColumn}
      onClick={() => {
        action(step)
      }}
    >
      <Image src={icon} alt="icon" />
      <div className="text">
        <h6 className="category">{category}</h6>
        <p className="name_product">
          {nameProduct || 'Todavia no seleccionaste un motherboard'}
        </p>
      </div>
    </CardContainer>
  )
}

const CardContainer = styled.div`
  cursor: ${(props) => (props.disabled ? 'inherit' : 'pointer')};
  width: 295px;
  height: 118px;
  background: ${(props) => (props.selected ? '#E1EEE2' : '#fff')};
  border-left: ${(props) =>
    props.selected ? ' 5px solid #120628' : '  5px solid #16e000'};
  display: flex;
  flex-direction: row;
  padding: 27px 15px;
  gap: 16px;
  border-radius: 8px;
  opacity: ${(props) => props.disabled && '0.45'};
  transition: all ease-in-out 0.3s;
  transform: ${(props) => props.selected && 'translateX(-10px)'};

  .category {
    margin: 0 0 10px;
    font-style: normal;
    font-weight: 600;
    font-size: 14px;
    line-height: 18px;
    color: #120628;
  }

  .name_product {
    font-style: normal;
    font-weight: 400;
    font-size: 14px;
    line-height: 20px;
    color: #707070;
  }
  &:hover {
    transform: ${(props) =>
      props.isColumn ? 'translateX(-10px)' : 'translateY(-10px)'};
    box-shadow: ${(props) =>
      props.isColumn
        ? ' 6px 0px 6px rgba(0, 0, 0, 0.2)'
        : ' 4px 4px 4px rgba(0, 0, 0, 0.1)'};
  }
`
