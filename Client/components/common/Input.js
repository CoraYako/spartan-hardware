import styled from 'styled-components'

export const Input = ({
  label,
  placeholder,
  register,
  errors,
  type,
  margin,
}) => {
  return (
    <ContainerInput margin={margin}>
      <label className="label_input"> {label}</label>
      <CustomInput {...register} placeholder={placeholder} type={type} />
      {errors && <p className="errors">{errors}</p>}
    </ContainerInput>
  )
}

const ContainerInput = styled.div`
  display: flex;
  flex-direction: column;
  margin: ${(props) => props.margin};
  max-width: 260px;
  min-width: 260px;
  position: relative;
  .label_input {
    font-weight: 400;
    font-size: 11px;
    line-height: 16px;
    color: #002155;
    margin-bottom: 4px;
  }
  .errors {
    font-weight: 400 !important;
    font-size: 11px !important;
    line-height: 16px;
    color: var(--errorRed);
    position: absolute;
    margin-bottom: 4px;
    bottom: -25px;
  }
`

const CustomInput = styled.input`
  outline: none;
  border: none;
  max-width: 260px;
  height: 30px;
  padding: 0 14px;
  font-style: normal;
  font-weight: 400;
  font-size: 14px;
  line-height: 21px;
  width: 100%;
  &:focus {
    border: none;
    outline: none;
  }
  &::placeholder {
    color: rgba(112, 112, 112, 0.5);
  }
`
