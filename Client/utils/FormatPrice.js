export default function FormatPrice(n, cuotes, quantity) {
  if (cuotes) {
    let cuote = n / 12
    return cuote.toLocaleString('es-ES', {
      minimumFractionDigits: 2,
      maximumFractionDigits: 2,
    })
  } else {
    let totalAmount = quantity * n
    return totalAmount.toLocaleString('es-ES', {
      minimumFractionDigits: 2,
      maximumFractionDigits: 2,
    })
  }
}
