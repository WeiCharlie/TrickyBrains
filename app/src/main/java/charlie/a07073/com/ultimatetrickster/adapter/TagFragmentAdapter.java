package charlie.a07073.com.ultimatetrickster.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * 新闻标签fragment适配器
 *
 * @author Kido
 */

public class TagFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;
    public FragmentManager fm;

    public TagFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fm = fm;
        this.mFragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments == null ? null : mFragments.get(position);
    }

    @Override
    public Fragment instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container,
                position);
        fm.beginTransaction().show(fragment).commit();
        return fragment;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        Fragment fragment = mFragments.get(position);
        fm.beginTransaction().hide(fragment).commit();
    }
    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }
}
