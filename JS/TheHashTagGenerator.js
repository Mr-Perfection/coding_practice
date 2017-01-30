function generateHashtag (str) {
  if (!str) return false;
  str = str.replace(/\b\w/g, l => l.toUpperCase());
  str = str.replace(/\s+/g, '');
  let result = "#" + str;
  if (result.length > 140)
    return (false);
  return result;
}
