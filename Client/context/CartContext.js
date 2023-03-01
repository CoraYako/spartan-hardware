import { useMemo, useState, createContext, useEffect } from 'react'

export const CartContext = createContext()

const CartProvider = ({ children }) => {
  const [cart, setCart] = useState([])

  useEffect(() => {
    if (typeof window !== 'undefined') {
      const cartFromLocalStorage = localStorage.getItem('cart')
      return cartFromLocalStorage
        ? setCart(JSON.parse(cartFromLocalStorage))
        : []
    }
  }, [])

  const saveCartToLocalStorage = (cart) => {
    localStorage.setItem('cart', JSON.stringify(cart))
  }

  const updateCartAndSaveToLocalStorage = (updatedCart) => {
    setCart(updatedCart)
    saveCartToLocalStorage(updatedCart)
  }

  const addToCart = (product) => {
    const existingProductIndex = cart.findIndex(
      (item) => item.id === product.id,
    )

    if (existingProductIndex >= 0) {
      const existingProduct = cart[existingProductIndex]
      const updatedProduct = {
        ...existingProduct,
        quantityInCart: existingProduct?.quantityInCart + 1,
      }

      if (updatedProduct.quantityInCart > product.quantity) {
        updatedProduct.quantityInCart = product.quantity
      }

      const updatedCart = [...cart]
      updatedCart[existingProductIndex] = updatedProduct
      updateCartAndSaveToLocalStorage(updatedCart)
    } else {
      const updatedProduct = { ...product, quantityInCart: 1 }

      if (updatedProduct.quantityInCart > product.quantity) {
        updatedProduct.quantityInCart = product.quantity
      }

      const updatedCart = [...cart, updatedProduct]
      updateCartAndSaveToLocalStorage(updatedCart)
    }
  }

  const removeFromCart = (productId) => {
    const updatedCart = cart.filter((item) => item.id !== productId)
    updateCartAndSaveToLocalStorage(updatedCart)
  }

  const emptyCart = () => {
    const updateCart = []
    updateCartAndSaveToLocalStorage(updateCart)
  }

  const cartValues = useMemo(
    () => ({ cart, addToCart, removeFromCart, emptyCart }),
    [cart],
  )

  return (
    <CartContext.Provider value={cartValues}>{children}</CartContext.Provider>
  )
}

export default CartProvider
