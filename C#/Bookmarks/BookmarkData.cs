using Bookmarks.Components;
using Newtonsoft.Json;
using System;
using System.Text.RegularExpressions;

namespace Bookmarks {

    public class BookmarkData : IEquatable<BookmarkData> {
        [JsonIgnore]
        public Bookmark AsControl;
        private string name;
        public string Name { 
            get => name;
            set => name = value?.Trim() ?? string.Empty;
        }
        public string Description { get; set; }

        private string url;
        public string Url {
            get => url;
            set {
                //Add "www." at the start if no protocol is specified
                if(Regex.IsMatch(value, @"^((((https?)|(s?ftp))://)|(ww(w|\d)\.))", RegexOptions.IgnoreCase)) {
                    url = value;
                }else {
                    url = $"www.{value}";
                }
            }
        }

        public bool Equals(BookmarkData bookmark)
            => bookmark.Url.Equals(Url, StringComparison.OrdinalIgnoreCase)
            || (bookmark.Name.Trim().Equals(Name, StringComparison.OrdinalIgnoreCase)
                && !string.IsNullOrWhiteSpace(Name));
    }

}
