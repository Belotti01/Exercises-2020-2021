using System.Windows.Forms;

namespace Bookmarks.Components {

    public partial class BookmarksList : UserControl {
        private int BookmarkWidth => Width - 30;

        public BookmarksList() {
            InitializeComponent();
            listBookmarks.HorizontalScroll.Enabled = false;
        }

        public void Append(Bookmark bookmark) {
            listBookmarks.Controls.Add(bookmark);
            listBookmarks.Controls[^1].Width = BookmarkWidth;
            listBookmarks.Controls[^1].Anchor = AnchorStyles.Left | AnchorStyles.Top;
        }

        public bool TryAdd(Bookmark bookmark) {
            foreach(Control ctrl in listBookmarks.Controls) {
                if(ctrl is Bookmark bm && bm.Data.Equals(bookmark.Data))
                    return false;
            }

            bookmark.Width = BookmarkWidth;
            listBookmarks.Controls.Add(bookmark);
            listBookmarks.Controls.SetChildIndex(bookmark, 0);
            return true;
        }

        public void Remove(Bookmark bookmark)
            => listBookmarks.Controls.Remove(bookmark);

        private void OnResize(object sender, System.EventArgs e) {
            int newSize = BookmarkWidth;
            foreach(Control ctrl in listBookmarks.Controls) {
                ctrl.Width = newSize;
            }
            listBookmarks.HorizontalScroll.Enabled = false;
        }
    }

}
