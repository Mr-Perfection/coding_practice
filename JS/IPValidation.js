function isValidIP(str) {
  
  console.log(str);
  console.log(hasValidInput(str));
  if (!hasValidInput(str)) return false;
  if (str.length > 15) return false;
  return true;
}

function hasWhiteSpace(str) {
  return /\s/g.test(str);
}
function hasValidInput(str) {
  return /^(?!.*\.$)((1?\d?\d|25[0-5]|2[0-4]\d)(\.|$)){4}$/.test(str);
}

^ start of string
  (?!0)         Assume IP cannot start with 0
  (?!.*\.$)     Make sure string does not end with a dot
  (
    (
    1?\d?\d|   A single digit, two digits, or 100-199
    25[0-5]|   The numbers 250-255
    2[0-4]\d   The numbers 200-249
    )
  \.|$ the number must be followed by either a dot or end-of-string - to match the last number
  ){4}         Expect exactly four of these
$ end of string